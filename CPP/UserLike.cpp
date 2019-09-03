#include<iostream>
#include<vector>
#include<unordered_map>
#include<algorithm>

using namespace std;

int main()
{
    int n;
		cin >> n;
    unordered_map<int, vector<int> > k_index;
    for(int i = 1;i <= n;i++)
    {
        int data;cin >> data;
        k_index[data].push_back(i);
    }
    //输入查询
    int q;cin >> q;
    while(q--)
    {
        int l, r, k;
        cin >> l >> r >> k;
        unordered_map<int, vector<int> >::iterator temp_it = k_index.find(k);
        if(temp_it == k_index.end())
            cout << 0<< endl;
        else
        {
            //二分查找
            auto ln = lower_bound(temp_it->second.begin(), temp_it->second.end(),l);
            auto rn = upper_bound(temp_it->second.begin(), temp_it->second.end(),r);
            cout << rn - ln << endl;
        }
    }
    return 0;
}
