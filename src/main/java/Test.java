//import com.diplomas.service.cloud.ServiceAccountCredentials;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.DriveScopes;
//import com.google.api.services.drive.model.File;
//import com.google.api.services.drive.model.FileList;
//import com.google.common.base.Throwables;
//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
//import com.sun.org.apache.xml.internal.security.utils.Base64;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.security.KeyFactory;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by Dima on 17.05.2016.
// */
//public class Test {
//
//    private static final String APPLICATION_NAME = "docs";
//
//    private static final String JSON_FILE_PATH = "/cloud_creds.json";
//
//    private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE);
//
//    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
//
//    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
//
//    private static String IDENTITY;
//
//    private static String CREDENTIALS;
//
//    static {
//        ObjectMapper mapper = new ObjectMapper();
//        ServiceAccountCredentials credentials = null;
//        try {
//           credentials =  mapper.readValue(
//                     Test.class.getResourceAsStream(JSON_FILE_PATH),
//                    ServiceAccountCredentials.class
//            );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        IDENTITY = credentials.getClient_email();
//        CREDENTIALS = credentials.getPrivate_key();
//    }
//
//    public static void main(String[] args) throws IOException {
//        // Build a new authorized API client service.
//        Drive service = getDriveService();
//
//        // Print the names and IDs for up to 10 files.
//        FileList result = service.files().list()
//                .setPageSize(10)
//                .setFields("nextPageToken, files(id, name)")
//                .execute();
//        List<File> files = result.getFiles();
//        if (files == null || files.size() == 0) {
//            System.out.println("No files found.");
//        } else {
//            System.out.println("Files:");
//            for (File file : files) {
//                System.out.printf("%s (%s)\n", file.getName(), file.getId());
//            }
//        }
//    }
//
//    public static Drive getDriveService() throws IOException {
//        Credential credential = getGoogleCredentials();
//        return new Drive.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, credential)
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }
//
//    private static GoogleCredential getGoogleCredentials() {
//        try {
//            return new GoogleCredential.Builder()
//                    .setTransport(HTTP_TRANSPORT)
//                    .setJsonFactory(JSON_FACTORY)
//                    .setServiceAccountId(IDENTITY)
//                    .setServiceAccountPrivateKey(createKey(CREDENTIALS))
//                    .setServiceAccountScopes(SCOPES)
//                    .build();
//        } catch (NoSuchAlgorithmException | InvalidKeySpecException | Base64DecodingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private  static PrivateKey createKey(String credential) throws NoSuchAlgorithmException, InvalidKeySpecException, Base64DecodingException {
//        return KeyFactory.getInstance("RSA")
//                .generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(formatCredentials(credential))));
//    }
//
//    private static String formatCredentials(String cred) {
//        return cred.replaceAll("\n", "")
//                .replaceAll("-----BEGIN PRIVATE KEY-----", "")
//                .replaceAll("-----END PRIVATE KEY-----", "");
//    }
//}
