package modals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Headline{
  @SerializedName("main")
  @Expose
  private String main;
  @SerializedName("print_headline")
  @Expose
  private String print_headline;
  public void setMain(String main){
   this.main=main;
  }
  public String getMain(){
   return main;
  }
  public void setPrint_headline(String print_headline){
   this.print_headline=print_headline;
  }
  public String getPrint_headline(){
   return print_headline;
  }
}