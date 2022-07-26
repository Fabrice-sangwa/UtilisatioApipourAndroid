package org.esisalama.mobile.apiapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GitHubUserService {

    //on passe en param etre le end point du serveur pour que ce getter prenne les users
    @GET("/users/{id}")
    Call<GitHubUsers> getUser(@Path("id") int id);
}
