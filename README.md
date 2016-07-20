# ClearRecyclerAdapter

[![Build Status](https://travis-ci.org/Prokky/ClearRecyclerAdapter.svg?branch=master)](https://travis-ci.org/Prokky/ClearRecyclerAdapter)
[![codecov](https://codecov.io/gh/Prokky/ClearRecyclerAdapter/branch/master/graph/badge.svg)](https://codecov.io/gh/Prokky/ClearRecyclerAdapter)
[ ![Download](https://api.bintray.com/packages/prokky/maven/clearrecycleradapter/images/download.svg) ](https://bintray.com/prokky/maven/clearrecycleradapter/_latestVersion)

Boilerplate code free Adapter for RecyclerView.

##Usage
To include this library to your project add dependency in **build.gradle** file:
```java
dependencies {
    compile 'com.prokkypew:clearrecycleradapter:1.0.0'
}
```
Create your Adapter class which extends ClearRecyclerAdapter and implement some functions.
```java

public class YourAdapter extends ClearRecyclerAdapter<YourObject> {
    @Override
    protected ClearRecyclerViewHolder getViewHolder(View view, int viewType) {
        return new YourViewHolder(view);
    }

    @Override
    protected int getItemLayout(int viewType) {
        return R.layout.your_list_item;
    }

    public class YourViewHolder extends ClearRecyclerAdapter.ClearRecyclerViewHolder<YourObject> {
        @BindView(R.id.title)
        TextView titleText;

        public YourViewHolder(View itemView) {
            super(itemView);
            Butterknife.bind(this, v); //just do it any way you like
        }

        @Override
        public void bind(YourObject item) {
            titleText.setText(item.name); //onBindViewHolder code here
        }
    }
}
```

Modify data int the adapter with this:
```java
adapter.set(List<T> items);
adapter.addAll(List<T> items);
adapter.add(T item);
adapter.add(T item, int position);
adapter.update(T item);
adapter.remove(T item);
adapter.clear();
List<T> items = adapter.getItems();
```

You can specify click listeners for items in a classic way of extending ViewHolder:
```java
public class YourViewHolder extends ClearRecyclerAdapter.ClearRecyclerViewHolder<YourObject> 
                            implements View.OnClickListener{


        public YourViewHolder(View itemView) {
            super(itemView);
            ...
            itemView.setOnClickListener(this);
        }
        
        ...
        
        @Override
        public void onClick(View view) {
            //CLICK!
        }
    }
```

If you need the View types for your adapter, feel free to use viewType parameter in getViewHolder(View, int) and getItemLayout(int) functions. Don't forget to override getItemViewType(int) int your adapter:
```java
    @Override
    protected ClearRecyclerViewHolder getViewHolder(View view, int viewType) {
        switch(viewType){
            case FIRST: return new FirstViewHolder(view);
            case SECOND:
            default: return new SecondViewHolder(view);
        }
    }

    @Override
    protected int getItemLayout(int viewType) {
        switch(viewType){
            case FIRST: return R.layout.first_layout;
            case SECOND:
            default: return R.layout.second_layout;
        }
    }
    @Override
    public int getItemViewType(int position) {
        // return viewtype for position
    }
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
