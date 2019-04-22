import com.zoho.cloud.function.Context;
import com.zoho.cloud.function.basic.*;
 
import java.lang.Math;

public class EMI implements ZCFunction
{
	public void runner(Context context, BasicIO basicIO) throws Exception
    {
    	//int principal = Integer.parseInt((String)basicIO.getParameter("principal")); 
        //double rate_pa = Double.parseDouble((String)basicIO.getParameter("rate_pa")); 
        int principal = 13000;
        double rate_pa = 20.0;
        double rate_pm = (rate_pa/12) /100 ;
    	int duration = Integer.parseInt((String)basicIO.getParameter("duration_in_months")); 
    	double emi = (principal*rate_pm*(Math.pow((1+rate_pm),duration)))/(Math.pow((1+rate_pm),duration)-1);// [P x R x (1+R)^N]/[(1+R)^ (N-1)],
    	basicIO.write("The Selected Product Amount is :: "+ principal +"\t");
        basicIO.write("Interest Rate pa as per company is :: "+rate_pa+"\t");
        basicIO.write("EMI :: Rs." +emi); 
    }
}
