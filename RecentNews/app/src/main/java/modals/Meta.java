package modals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Meta{
  @SerializedName("hits")
  @Expose
  private Integer hits;
  @SerializedName("offset")
  @Expose
  private Integer offset;
  @SerializedName("time")
  @Expose
  private Integer time;
  public void setHits(Integer hits){
   this.hits=hits;
  }
  public Integer getHits(){
   return hits;
  }
  public void setOffset(Integer offset){
   this.offset=offset;
  }
  public Integer getOffset(){
   return offset;
  }
  public void setTime(Integer time){
   this.time=time;
  }
  public Integer getTime(){
   return time;
  }
}