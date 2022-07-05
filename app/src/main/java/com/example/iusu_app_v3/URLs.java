package com.example.iusu_app_v3;

public class URLs {

  private static final String ROOT_XAMPP_URL = "http://10.11.1.125/iusu_app_conn_v4/registrationapi.php?apicall=";

  private static final String ROOT_URL_000WEBHOSTAPP = "https://iusuapp.000webhostapp.com/iusu_app_conn_v4/login_signup_api.php/?apicall=";
  private static final String ROOT_URL_000WEBHOSTAPP_PROFILE_PIC_UPLOAD = "https://iusuapp.000webhostapp.com/iusu_app_conn_v4/insert_profile_image_api.php/?apicall=";
  private static final String ROOT_URL_000WEBHOSTAPP_NEWS_UPLOAD = "https://iusuapp.000webhostapp.com/iusu_app_conn_v4/news_api.php/?apicall=";
  private static final String ROOT_URL_000WEBHOSTAPP_ANNOUNCEMENT_UPLOAD = "https://iusuapp.000webhostapp.com/iusu_app_conn_v4/announcement_api.php?apicall=";
  private static final String ROOT_URL_000WEBHOSTAPP_EVENT_UPLOAD = "https://iusuapp.000webhostapp.com/iusu_app_conn_v4/event_api.php?apicall=";
  private static final String ROOT_URL_000WEBHOSTAPP_GUILD = "https://iusuapp.000webhostapp.com/iusu_app_conn_v4/guild_official_api.php/?apicall=";


  public static final String URL_REGISTER = ROOT_URL_000WEBHOSTAPP + "signup";
  public static final String URL_LOGIN= ROOT_URL_000WEBHOSTAPP + "login";
  public static final String URL_UPLOAD_PROFILE_PIC=ROOT_URL_000WEBHOSTAPP_PROFILE_PIC_UPLOAD+"uploadpic";
  public static final String URL_NEWS_UPLOAD=ROOT_URL_000WEBHOSTAPP_NEWS_UPLOAD+"make_post";
  public static final String URL_NEWS_FETCH=ROOT_URL_000WEBHOSTAPP_NEWS_UPLOAD+"getnews";
  public static final String URL_ANN_UPLOAD=ROOT_URL_000WEBHOSTAPP_ANNOUNCEMENT_UPLOAD+"make_announcement";
  public static final String URL_ANN_GET_ANN=ROOT_URL_000WEBHOSTAPP_ANNOUNCEMENT_UPLOAD+"getannouncements";

 public static final String URL_EVENT_UPLOAD=ROOT_URL_000WEBHOSTAPP_EVENT_UPLOAD+"make_post";
  public static final String URL_GET_EVENT=ROOT_URL_000WEBHOSTAPP_EVENT_UPLOAD+"getevents";


  //guild official

  public static final String URL_ADD_GUILD_OFFICIAL=ROOT_URL_000WEBHOSTAPP_GUILD+"add_guild_official";
  public static final String URL_FETCH_GUILD_OFFICIAL=ROOT_URL_000WEBHOSTAPP_GUILD+"fetch_guild_officials";
  public static final String URL_UPDATE_GUILD_OFFICIAL=ROOT_URL_000WEBHOSTAPP_GUILD+"update_guild_officials";


}
