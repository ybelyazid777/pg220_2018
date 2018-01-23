package prjtjavaaa;

public abstract class Meteo {
	protected  double temp[];

	

	protected int n_jours;
	protected long hum[];
	protected double win[];

	public Meteo(int n_jours){
		this.n_jours = n_jours;
		
		this.win = new double[n_jours];
		this.temp = new double[n_jours];
		this.hum = new long[n_jours];
	}
	
	
	public double get_temp(int j){
		return this.temp[j];
	}
	public double get_win(int j){
		return this.win[j];
	}
	public long get_hum(int j){
		return this.hum[j];
	}
	
	public void description(String title,int h_y,int w_y,int flag){
		System.out.print("+-------------+");
		for (int i =0;i<this.n_jours;i++){
			System.out.print("--------+");
		}
		System.out.println("");
		
		
				
		
		System.out.print(title);
		
		if(flag==1)
			for (int i =0;i<this.n_jours;i++){
				System.out.print("  "+  (int)(1.8*this.temp[i]+32 )+"F   |");
			}
		
		
		else{
			
				for (int i =0;i<this.n_jours;i++){
				System.out.print("  "+ String.format("%02d",(int)this.temp[i])+"°   |");
				}
		}
		
		if(h_y!=0){
			System.out.println("");
			System.out.print("|             |");
			
		
			
			for (int i =0;i<this.n_jours;i++){
					System.out.print("  "+ String.format("%02d",(int)this.hum[i]) +"%   |");
				
		}
		}
		if(w_y!=0){
			System.out.println("");
			System.out.print("|             |");
			for (int i =0;i<this.n_jours;i++){
				System.out.print("  "+ String.format("%02d",(int)this.win[i])+"km/h|");
			}
		}
		System.out.println("");
	}
	
	}
