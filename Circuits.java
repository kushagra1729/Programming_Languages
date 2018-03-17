    /* package codechef; // don't place package name! */
    // write package when running on local VirtualMachineError
    // https://www.codechef.com/problems/CIRCUITS
 
    import java.util.* ;
     
    class node
    {
        int val,a,b ;
        void setup(int x,int y,int z){
            val=x ;
            a=y ;
            b=z ;
        }
    }
     
    class circuits
    {
        static node arr[]=new node[101] ;
        static double finder(int a, double p){
            if(arr[a].val==0){
                return p ;
            }
            double one=finder(arr[a].a,p) ;
            double two=finder(arr[a].b,p) ;
            if(arr[a].val==1){
                return one+two-one*two ;
            }
            else{
                return one*two ;
            }
        }
        public static void main(String args[]){
            Scanner s= new Scanner(System.in) ;
            int t=s.nextInt() ;
            while(t>0){
                int n ;
                n=s.nextInt() ;
                for(int i=1 ; i<=n ; i++){
                    arr[i]=new node() ;
                    int val,a,b ;
                    val=s.nextInt() ;
                    if(val==0){
                        arr[i].setup(val,0,0) ;
                    }
                    else{
                        a=s.nextInt() ;
                        b=s.nextInt() ;
                        arr[i].setup(val,a,b) ;
                    }
                }
                double high=1.0,low=0.0 ;
                double eps=1e-9 ;
                while((high-low)>eps){
                    double mid=(high+low)/2.0 ;
                    if(finder(n,mid)>0.5){
                        high=mid ;
                    }
                    else{
                        low=mid; 
                    }
                }
                t-- ;
                System.out.printf("%.5f\n",high) ;
            }
        }
    } 
