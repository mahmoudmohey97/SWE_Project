package sweproject;

public class Notification
{
		private String username;
		private int postid;
		public Notification()
		{
			username = "";
			postid = 0;
		}
		public Notification(String username2, int postid2) 
		{
			this.username = username2;
			this.postid = postid2;
		}
		public String getUsername()
		{
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public int getPostid() {
			return postid;
		}
		public void setPostid(int postid) {
			this.postid = postid;
		}
		
}
	
