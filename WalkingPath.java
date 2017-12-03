class WalkingPath{
	private void pathCalculations(int xCoordinate,int yCoordinate, int direction, char path[])
	{	
		String directionSting = "";
		for(int i=0;i<path.length;i++) {		
			char move = path[i];
			if (move == 'R') {	
				direction = ( direction + 1)%4; 			  
				}		      
			  else if (move == 'L') {
				  direction = (4 + direction - 1)%4;	    	     	  
			  }   	  
			 else if (move == 'W')
			  {
				 if (direction == 0 )//North	            
				 yCoordinate = yCoordinate+Integer.parseInt( Character.toString(path[i+1]));
				 else if (direction == 1 )//East	            
				 xCoordinate = xCoordinate +Integer.parseInt( Character.toString(path[i+1]));
				 else if (direction == 2 )//South	            
				 yCoordinate = yCoordinate - Integer.parseInt( Character.toString(path[i+1]));
				 else if(direction == 3 ) //  West	            
				 xCoordinate = xCoordinate -Integer.parseInt( Character.toString(path[i+1]));
			  }
		}	
		directionSting = direction==2?"SOUTH":direction == 0?"NORTH":direction == 3?"WEST":direction == 1?"EAST":"";	
		
		System.out.println(xCoordinate);
		System.out.println(yCoordinate);
		System.out.println(directionSting);
	}
	
	public static void main(String args[]) {
		try {
			int xCoordinate = Integer.parseInt(args[0]);
			int yCoordinate = Integer.parseInt(args[1]);
			String direction = args[2].trim();			
			char walk_path[] = args[3].toCharArray();			
			int direct = -1;
			WalkingPath walk = new WalkingPath();
			
			if(direction.equals("SOUTH")) {
				direct = 2;
			}else if(direction.equals("NORTH")) {
				direct = 0;
			}else if(direction.equals("WEST")) {
				direct = 3;
			}else if(direction.equals("EAST")) {
				direct = 1;
			}		
			walk.pathCalculations(xCoordinate,yCoordinate,direct,walk_path);			
		}
		catch (ArrayIndexOutOfBoundsException exceptionObj) {
			System.out.println("Please Insert four arguments: ");
			System.out.println("First argument for X-Coordinate.");
			System.out.println("Second argument for Y-Coordinate.");
			System.out.println("Third argument for Direction in CAPS.");
			System.out.println("Fourth argument for Walking Code.");
		}
		
	}
	
}