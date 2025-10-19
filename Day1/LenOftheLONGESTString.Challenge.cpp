#include<iostream>
using namespace std;

int main(){
    int n;
    cout<<"Enter the number of Elements you want to take as input"<<endl;
    cin>>n;
    string arr[100];

    for(int i=0;i<n;i++){
        cout<<"Enter the String at "<<i<<"Position"<<endl;
        cin>>arr[i];
    }
    int max =0;
    for(int i=0;i<n;i++){
        if(arr[i].length()>max){
            max=arr[i].length();
        }
    }
    cout<<"Maximum Length of a word is "<<max<<endl;

}