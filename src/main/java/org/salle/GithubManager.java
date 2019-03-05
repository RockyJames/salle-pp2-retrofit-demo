package org.salle;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;



public class GithubManager {


    public static void main(String[] args) {

        final String BASE_URL = "https://api.github.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService githubService = retrofit.create(GithubService.class);

        Call<List<Repo>> call = githubService.listRepos("jaumecampeny");

        try {
            Response<List<Repo>> response = call.execute();

            if (response.isSuccessful()) {
                System.out.println(response.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


