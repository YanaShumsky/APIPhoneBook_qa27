package okHttpTests;

import com.google.gson.Gson;
import dto.ContactsDto;
import dto.ErrorDto;
import dto.GetAllContactsDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHttpGetAllContactDtoTest {

    @Test
    public void testGetAllContacts() throws IOException, IOException {
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://contacts-telran.herokuapp.com/api/contact")
                .addHeader("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImpvaG45MDkwQG1haWwuY29tIn0.uFp-ZueoxtelSBWIrrsl7SmMAKUNBmjQNj33Zh2ik6w")
                .build();
        Response response = client.newCall(request).execute();

        if(response.isSuccessful()){
            GetAllContactsDto getAllContactsDto= gson.fromJson(response.body().string(),GetAllContactsDto.class);
            for(ContactsDto contact: getAllContactsDto.getContacts()){
                System.out.println(contact.getId() + "***"+ contact.getName() + "***");
                System.out.println("==============================");
            }
        }else {
            ErrorDto errorDto = gson.fromJson(response.body().string(),ErrorDto.class);
            System.out.println(errorDto.getMessage() +errorDto.getCode());
        }


    }
}
