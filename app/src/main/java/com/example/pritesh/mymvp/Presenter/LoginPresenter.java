package com.example.pritesh.mymvp.Presenter;



import com.example.pritesh.mymvp.BackTask.RetrofitBuild;
import com.example.pritesh.mymvp.Interface.LoginView;
import com.example.pritesh.mymvp.Model.AquLoginPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pritesh on 9/15/2017.
 */

public class LoginPresenter {

  private static int maxAttempt = 3;

    private LoginView loginView;

    private int loginAttempt;

    private RetrofitBuild retrofitBuild;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;

        retrofitBuild = new RetrofitBuild();
    }

    public int incrementLoginAttempt(){

        loginAttempt = loginAttempt + 1;

        return loginAttempt;

    }

    public boolean isLoginAttemptExcced(){

        return loginAttempt >= maxAttempt;
    }

       public void DoLogin(String username, String password){

           loginView.showprogress();

           if(isLoginAttemptExcced()){

             loginView.showMaxAttemptLogin();

               loginView.hideprogress();

           }
           else {

               Call<AquLoginPojo> pojoCall = retrofitBuild.allApi().getLogin(username,password);

               pojoCall.enqueue(new Callback<AquLoginPojo>() {
                   @Override
                   public void onResponse(Call<AquLoginPojo> call, Response<AquLoginPojo> response) {


                       loginView.hideprogress();

                       if(response.body().getSuccess() == 1){


                           loginView.showLoginSuccessMsg();

                       }
                       else {

                           loginView.showErrorMeassageUserNamePassword();
                           incrementLoginAttempt();

                       }



                   }

                   @Override
                   public void onFailure(Call<AquLoginPojo> call, Throwable t) {

                       loginView.hideprogress();

                       loginView.showErrorMeassageUserNamePassword();



                   }
               });







            /*  if(username.equals("yash") && password.equals("yash")){


                 loginView.showLoginSuccessMsg();
                //  return;

              }
              else {

                  incrementLoginAttempt();
                  loginView.showErrorMeassageUserNamePassword();

              }
*/



           }



       }


}
