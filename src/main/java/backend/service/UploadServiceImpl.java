package backend.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import backend.dto.ProductDTO;
import backend.exception.UploadException;

@Service
public class UploadServiceImpl implements UploadService {

	private static final String AWS_S3_TITLE_KEY = "title";
	private static final String AWS_S3_PRODUCT_PHOTO_BUCKET_NAME = "foodsaver-photo";
	
	@Override
	public void uploadProductPhoto(ProductDTO productDTO) {
		String productName = productDTO.getName();
		String base64Data = productDTO.getBase64Data();

		if (base64Data != null && base64Data.length() > 0) {
			String s3Path = uploadProductPhoto(productName, base64Data);
			productDTO.setS3ImagePath(s3Path);
		}
	}

	private String uploadProductPhoto(String title, String base64Data) {
		Regions clientRegion = Regions.AP_SOUTHEAST_1;
		String bucketName = AWS_S3_PRODUCT_PHOTO_BUCKET_NAME;
		String base64Metadata[] = base64Data.split(";");
		String base64ContentType[] = base64Metadata[0].split(":");
		String contentType = base64ContentType[1];
		String imageExtension = contentType.split("/")[1];
		
		String objectKey = UUID.randomUUID().toString() + "." + imageExtension;
		
		byte[] bI = Base64.decodeBase64((base64Data.substring(base64Data.indexOf(",")+1)).getBytes());
		InputStream input = new ByteArrayInputStream(bI);
		
		return uploadObjectToS3(clientRegion, bucketName, objectKey, title, input, contentType);
	}

	private String uploadObjectToS3(Regions clientRegion, String bucketName, String objectKey, String title,
			InputStream input, String contentType) {
		String sharableLink = null;

		try {
			// This code expects that you have AWS credentials set up per:
			// https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion).build();
			
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType(contentType);
			metadata.addUserMetadata(AWS_S3_TITLE_KEY, title);
			
			// Upload a file as a new object with ContentType and title specified.
			PutObjectRequest request = new PutObjectRequest(bucketName, objectKey, input, metadata);
			request.setMetadata(metadata);

			s3Client.putObject(request);
			s3Client.setObjectAcl(bucketName, objectKey, CannedAccessControlList.PublicRead);

			// Upload a file as a new object with ContentType and title specified.
			URL url = s3Client.getUrl(bucketName, objectKey);
			sharableLink = url.toExternalForm();
		} catch (AmazonServiceException e) {
			// The call was transmitted successfully, but Amazon S3 couldn't process
			// it, so it returned an error response.
			e.printStackTrace();
			throw new UploadException(e.getMessage());
		} catch (SdkClientException e) {
			// Amazon S3 couldn't be contacted for a response, or the client
			// couldn't parse the response from Amazon S3.
			e.printStackTrace();
			throw new UploadException(e.getMessage());
		}

		return sharableLink;
	}

}
