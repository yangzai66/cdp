
public class Demo {
	public static void main(String[] args) {
		int j=50;
		for(int k=6;k<17;k++){
		for(int i=1;i<6;i++){
			j++;
			System.out.println("INSERT INTO tf_mealtimes_chipcategory_relation ('SEQNO', 'MT_ID', 'CG_ID', 'PRICE') VALUES ('"+j+"', '"+i+"', 'kbs-"+k+"', '5');");
		}
		}
	}
}