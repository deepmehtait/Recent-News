package modals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Byline{
  @SerializedName("original")
  @Expose
  private String original;
  public void setOriginal(String original){
   this.original=original;
  }
  public String getOriginal(){
   return original;
  }
}