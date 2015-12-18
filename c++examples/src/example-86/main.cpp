#include<vector>
#include<list>
#include<iostream>
#include<iterator>
#include<algorithm>
#include<string>

using namespace std;

template <typename ForwardIterator>
void shift_left(ForwardIterator beg, ForwardIterator end) {
	typedef typename std::iterator_traits<ForwardIterator>::value_type value_type;

	if (beg != end) {
		value_type tmp(*beg);
		for(ForwardIterator i=beg++; i!=end; i++) {
			ForwardIterator ni = ::next(i);
			if(ni == end) {
				*i=tmp;
				break;
			}
			*i=*ni;
		}
	}
}

int main(int argc, char **argv) {
	vector<double> v = {3.14, 2.7, 1.57};
	list<double> l;
	::copy(v.begin(), v.end(), ::front_inserter(l));
	for(auto i : l) {
		cout<<i<<" ";
	}
	cout<<endl;
	::copy(l.begin(), l.end(), ::ostream_iterator<double>(cout, " "));
	cout<<endl;

	istream_iterator<int> isi(cin);
	istream_iterator<int> isieof;

	//::copy(isi, isieof, )

	//while(isi != isieof) {
	//	int x = *isi;
	//	cout<<">> "<<x*x<<endl;
	//	++isi;
	//}

	shift_left(l.begin(), l.end());
	::copy(l.begin(), l.end(), ::ostream_iterator<double>(cout, " "));
	cout<<endl;

}
