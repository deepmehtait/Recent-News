package modals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Keywords{
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("isMajor")
  @Expose
  private String isMajor;
  @SerializedName("rank")
  @Expose
  private Integer rank;
  @SerializedName("value")
  @Expose
  private String value;
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setIsMajor(String isMajor){
   this.isMajor=isMajor;
  }
  public String getIsMajor(){
   return isMajor;
  }
  public void setRank(Integer rank){
   this.rank=rank;
  }
  public Integer getRank(){
   return rank;
  }
  public void setValue(String value){
   this.value=value;
  }
  public String getValue(){
   return value;
  }
}