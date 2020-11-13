# RecyclerView

## 1.- Add Dependency 

```
Ctrl + Shift + A 

project structure

recyclerview
```

## 2.- Create the recyclerview inside XML

Create the recyclerview inside XML, dont forget put the **Id**

```
somethingRecyclerView
```

## 3.- Create the another Xml for items

```
list_item_something
```

Create xml resources for item view and don't forget put the **Id** for all components of this view


## 4.- Create the Adapter

- Create a new class for Adapter, this heritange for RecyclerView.Adapter<<NameAdapter.ViewHolderInnerClas>>
- 



## 5.- Create the new inner class that claim 

This claim should heritage from RecyclerView.ViewHolder


## 6.- Create the three methods thats claim for Adapter

1.- onCreateViewHolder: inflate and wrapper view of item (list_item_something)

2.- onBindViewHolder: Conect the Adapter with inner class

```
holder.bind(dataList.get(position))
```

3.- getItemCount: cantidad de items  (dataList.count)


## 7.- Make the inne class heritage from RecyclerView.ViewHolder


## 8.- Make constructor for inner class

this class will be set data to list_item_something component's

## 9.- Create a dataList for Adapter

This dataList will be inject for Contructor from Adapter

## 10.- Generate link to components of list_item_something in ViewHolder inner

create a properties for all component from list_item_something (las time use a bindView)


## 11.- Implements the generates methods

Implements the three method for Adapter.

## 12.- Create method in ViewHolder inner class to bind and use in onBindViewHolder

this methods receive the exactly item to show


## 13.- In Main set all necessary for RecyclerView works

This will be:

- Data: Create Data for Adapter or recive
- RecyclerView: Infalte RecyclerView
- Adapter: Instatiate Adapter, inject data to Adapter 
- Layoutmanager: Set Layoutmanget to RecyclerView
- Adapter: Set Adapter to RecyclerView


## 14.- Run.
