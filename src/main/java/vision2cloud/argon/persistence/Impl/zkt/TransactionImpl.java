package vision2cloud.argon.persistence.Impl.zkt;

import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import vision2cloud.argon.model.zkt.Person;
import vision2cloud.argon.model.zkt.ResponsePerson;
import vision2cloud.argon.model.zkt.ResponseTransaction;
import vision2cloud.argon.model.zkt.Transaction;
import vision2cloud.argon.persistence.zkt.TransactionPersistence;

import java.net.URISyntaxException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.*;

@Service("TransactionImpl")
public class TransactionImpl implements TransactionPersistence {
    private String basicUri = "https://v2cbloc-biosec-02.eastus2.cloudapp.azure.com:8098/api/";
    private String token = "7A7CBAA816F05D6CCE07803766B5E9E0FAB6ACCB3B2DFB8CCC3FE490F987C2FC";
    private String accLevelId = "8a8080887dc2880f017e06d4c68e2b05";
    private String dptCode = "16";

    private HttpHeaders createHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    @Override
    public ArrayList<Transaction> get(String initalDate, String endDate) throws URISyntaxException {
        try {
            System.out.println("GrabarPerson");

            // Crear un TrustManager que no realiza ninguna verificación
            TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                            // No implementation needed, accept all clients
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                            // No implementation needed, accept all servers
                        }
                    }
            };

            // Configurar SSLContext para confiar en todos los certificados
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            // Crear un HostnameVerifier que siempre retorna true
            HostnameVerifier allHostsValid = (hostname, session) -> true;
            // Instalar el HostnameVerifier personalizado
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            final Gson gson = new Gson();
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<?> requestEntity = new HttpEntity<>(createHttpHeaders());
            String urlTemplate = UriComponentsBuilder.fromHttpUrl(basicUri + "transaction/list" )
                    .queryParam("pageNo", 1)
                    .queryParam("pageSize", 1000)
                    .queryParam("access_token", token)
                    .encode()
                    .toUriString();
            System.out.println(urlTemplate);
            ResponseEntity<ResponseTransaction> response = restTemplate.exchange(
                    urlTemplate, HttpMethod.GET, requestEntity, ResponseTransaction.class);
            ArrayList<Transaction> transaction = response.getBody().getData();
            System.out.println("A grabar");
            System.out.println("grabo");
            System.out.println(transaction);
            return transaction;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
