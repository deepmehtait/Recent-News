package modals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Legacy{
  @SerializedName("xlarge")
  @Expose
  private String xlarge;
  @SerializedName("xlargewidth")
  @Expose
  private Integer xlargewidth;
  @SerializedName("xlargeheight")
  @Expose
  private Integer xlargeheight;
  public void setXlarge(String xlarge){
   this.xlarge=xlarge;
  }
  public String getXlarge(){
   return xlarge;
  }
  public void setXlargewidth(Integer xlargewidth){
   this.xlargewidth=xlargewidth;
  }
  public Integer getXlargewidth(){
   return xlargewidth;
  }
  public void setXlargeheight(Integer xlargeheight){
   this.xlargeheight=xlargeheight;
  }
  public Integer getXlargeheight(){
   return xlargeheight;
  }
}