# RecyclerView

## 0.- Config View to use ViewBinding


📄 build.gradle(Module: app)

```
android {
    compileSdkVersion 30
    buildToolsVersion "30.0.2"
.
.
    buildFeatures {
        viewBinding = true
    }
}    
```

## 1.- Add Dependency 

```
Ctrl + Shift + A 

project structure

recyclerview
```

## 2.- Create the recyclerview inside XML

Create the recyclerview inside XML, dont forget put the **Id**

```
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/titleTextView"
        />
```

somethingRecyclerView | recycler


## 3.- Create the another Xml for items

view_movie_item

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <ImageView
        android:id="@+id/profileImageView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"

        tools:srcCompat="@tools:sample/avatars" />

    <TextView
        android:id="@+id/titleTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/profileImageView"
        android:text="TextView" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

Create xml resources for item view and don't forget put the **Id** for all components of this view


## 4.- Prepare Dataclass 

```
data class Movie(val title: String, val cover: String)
```

## 5.- Create the Adapter

- Create a new class for Adapter, this heritange for RecyclerView.Adapter<<NameAdapter.ViewHolderInnerClas>>

```
class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    class ViewHolder : RecyclerView.ViewHolder(){

    }

}
```

- Make constructor that inject List<Movie>

```
class MoviesAdapter(private val movies: List<Movie>): 
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    ...
```

## 6.- Create the new inner class that claim 

This claim should heritage from RecyclerView.ViewHolder

```
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }
```

## 7.- Create the three methods thats claim for Adapter

1.- onCreateViewHolder: inflate and wrapper view of item (list_item_something)

2.- onBindViewHolder: Conect the Adapter with inner class

```
holder.bind(dataList.get(position))
```

3.- getItemCount: cantidad de items  (dataList.count)

```
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
```


## 8.- Make the inner class heritage from RecyclerView.ViewHolder

Musk take into account the parent class is abstract, then will be receibe arguments:

```
   class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }
```

Este guardara la vista que tenga una posicion espeficica que tenga en este momento

P: Que es el ViewHolder, es el componente dentro del Adapter que va a contener la vista.

## 9.- Make constructor for inner class

this class will be set data to list_item_something component's

For now we use a ViewBinding:

```
    class ViewHolder(private val binding: ViewMovieItemBinding) : RecyclerView.ViewHolder(binding.root){

    }
```

## 10.- Create a dataList for Adapter

This dataList will be inject for Contructor from Adapter

```
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movies: List<Movie> = listOf(
            Movie("Title 1", "url 1"),
            Movie("Title 2", "url 2"),
            Movie("Title 3", "url 3"),
            Movie("Title 4", "url 4"),
            Movie("Title 5", "url 5"),
            Movie("Title 6", "url 6"),
        )

        binding.recycler.adapter = MoviesAdapter(movies)
    }
}
```

## 11.- Generate link to components of list_item_something in ViewHolder inner

Create a properties for all component from list_item_something (las time use a bindView)

Now we use a ViewBinding, also we have access total to all component in list_item_something

```
// Don't need make anything here now.
```



## 12.- Implements the generates methods

Implements the three method for Adapter. and basic struct for **bind** method

```
class MoviesAdapter(private val movies: List<Movie>):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    class ViewHolder(private val binding: ViewMovieItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie) {

        }
    }

}
```


## 13.- Create method in ViewHolder inner class to bind and use in onBindViewHolder

this methods receive the exactly item to show

```
    class ViewHolder(private val binding: ViewMovieItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie) {
            binding.titleTextView.text = movie.title
        }
    }
```

## 14.- In Main set all necessary for RecyclerView works

This will be:

- Data: Create Data for Adapter or recive
- RecyclerView: Infalte RecyclerView
- Adapter: Instatiate Adapter, inject data to Adapter 
- Layoutmanager: Set Layoutmanget to RecyclerView
- Adapter: Set Adapter to RecyclerView

Un alcanze, el LayoutManager tambien se pude settear en el XML:

```
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movies: List<Movie> = listOf(
            Movie("Title 1", "url 1"),
            Movie("Title 2", "url 2"),
            Movie("Title 3", "url 3"),
            Movie("Title 4", "url 4"),
            Movie("Title 5", "url 5"),
            Movie("Title 6", "url 6")
        )

        binding.recycler.adapter = MoviesAdapter(movies)
        binding.recycler.layoutManager = LinearLayoutManager(this)

    }
}
```


## 15.- Run.

