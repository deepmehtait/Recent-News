package modals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Multimedia{
  @SerializedName("legacy")
  @Expose
  private Legacy legacy;
  @SerializedName("subtype")
  @Expose
  private String subtype;
  @SerializedName("width")
  @Expose
  private Integer width;
  @SerializedName("rank")
  @Expose
  private Integer rank;
  @SerializedName("type")
  @Expose
  private String type;
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("height")
  @Expose
  private Integer height;
  public void setLegacy(Legacy legacy){
   this.legacy=legacy;
  }
  public Legacy getLegacy(){
   return legacy;
  }
  public void setSubtype(String subtype){
   this.subtype=subtype;
  }
  public String getSubtype(){
   return subtype;
  }
  public void setWidth(Integer width){
   this.width=width;
  }
  public Integer getWidth(){
   return width;
  }
  public void setRank(Integer rank){
   this.rank=rank;
  }
  public Integer getRank(){
   return rank;
  }
  public void setType(String type){
   this.type=type;
  }
  public String getType(){
   return type;
  }
  public void setUrl(String url){
   this.url=url;
  }
  public String getUrl(){
   return url;
  }
  public void setHeight(Integer height){
   this.height=height;
  }
  public Integer getHeight(){
   return height;
  }
}