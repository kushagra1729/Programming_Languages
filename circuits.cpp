#include <bits/stdc++.h>
using namespace std ;
     
struct node
{
   	int val,a,b ;
};
node arr[101] ;
     
const double eps=1e-9 ;
    
double finder(int node, double mid)
{
   	if(arr[node].val==0)
   		return mid ;
   	double one=finder(arr[node].a,mid) ;
   	double two=finder(arr[node].b,mid) ;
   	if(arr[node].val==1){
   		return one+two-one*two ;
  	}
   	else{
   		return one*two ;
   	}
}
     
int main()
{
  	ios::sync_with_stdio(0) ;
   	cin.tie(0) ;
    
   	int t ;
   	cin >> t ;
   	while(t--){
   		int n ;
   		cin >> n ;
   		double req=0.5 ;
   		double high=1.0,low=0.0 ; 
   		for(int i=1 ; i<=n ; i++){
   			cin >> arr[i].val ;
   			if(arr[i].val!=0){
   				cin >> arr[i].a >> arr[i].b ;
   			}
   		}
   		while((high-low)>eps){
   			double mid=(high+low)/2.0 ;
   			if(finder(n,mid)>req){
   				high=mid ;
   			}
   			else
   				low=mid ;
   			// cout << "YO";
   		}
   		printf("%.5f\n",high) ;
   	}
   	return 0 ;
}