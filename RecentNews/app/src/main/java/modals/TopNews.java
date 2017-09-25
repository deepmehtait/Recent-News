package modals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class TopNews{
  @SerializedName("copyright")
  @Expose
  private String copyright;
  @SerializedName("response")
  @Expose
  private Response response;
  @SerializedName("status")
  @Expose
  private String status;
  public void setCopyright(String copyright){
   this.copyright=copyright;
  }
  public String getCopyright(){
   return copyright;
  }
  public void setResponse(Response response){
   this.response=response;
  }
  public Response getResponse(){
   return response;
  }
  public void setStatus(String status){
   this.status=status;
  }
  public String getStatus(){
   return status;
  }
}