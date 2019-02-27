import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetActiveDirectory {
	private boolean isMember;
	private final String[] groups = {"SDL RC-CH MO MM PE 3 1", "SDL RC-CH MO MM PE 3 2"};
	
	public GetActiveDirectory() {
		Process p = executeCmd("whoami /groups");
		if(p!=null) {
			getCmdOutput(p);
		}
	}
	
	public static void main(String[] args) {
		GetActiveDirectory g = new GetActiveDirectory();

	}
	
	public Process executeCmd(String command) {
		
		Runtime rd = Runtime.getRuntime();
		try {
			Process prc = rd.exec(command);
			return prc;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void getCmdOutput(Process p){
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		System.out.println("Output:");
		String s = null;
		this.isMember = false;
		try {
			while((s=input.readLine())!=null && !this.isMember) {
				boolean b = checkMember(this.groups, s);
				if(b) {
					setIsMember(true);
				}
			}
			if(this.isMember) {
				System.out.println("true!!");
			}else {
				System.out.println("false!!!");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public boolean checkMember(String[] groups, String s) {
		for(int i=0; i<groups.length; i++) {
			if(s.contains(groups[i])) {
				return true;
			}
		}
		return false;
	}
	
	private void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}
	
	
	

}
