package search.web.dao.entity;

public class Movie 
{
	private String code;
	private String title;
	private int runningTime;
	private String summary;
	private String releaseYear;
	private int ageRating;
	private String poster;
	
	public String getCode() 
	{
		return code;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public int getRunningTime() 
	{
		return runningTime;
	}
	public void setRunningTime(int runningTime) 
	{
		this.runningTime = runningTime;
	}
	public String getSummary() 
	{
		return summary;
	}
	public void setSummary(String summary) 
	{
		this.summary = summary;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getAgeRating() {
		return ageRating;
	}
	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
}
