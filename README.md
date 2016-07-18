# ClearRecyclerAdapter
Boilerplate code free Adapter for RecyclerView.

##Usage
Create your Adapter class which extends ClearRecyclerAdapter and implement some functions.
```java

public class YourAdapter extends ClearRecyclerAdapter<YourObject> {
    @Override
    protected ClearRecyclerViewHolder getViewHolder(View view) {
        return new YourViewHolder(view);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.your_list_item;
    }

    public class YourViewHolder extends ClearRecyclerAdapter.ClearRecyclerViewHolder {
        @BindView(R.id.title)
        TextView titleText;

        public YourViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(YourObject item) {
            titleText.setText(item.name);
        }
    }
}
```

You can specify click listeners for items:
```java
adapter.setOnHolderClickListener(...);
adapter.setOnHolderLongClickListener(...);
```

And you are done!

# License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
