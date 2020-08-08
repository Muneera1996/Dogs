package com.example.dogs.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

import com.example.dogs.R
import com.example.dogs.databinding.ItemDogBinding
import com.example.dogs.models.DogBreed
import com.example.dogs.util.getProgressDrawable
import com.example.dogs.util.loadImage
import com.example.dogs.views.fragments.ListFragmentDirections
import kotlinx.android.synthetic.main.item_dog.view.*
import okhttp3.internal.Util
import java.util.zip.Inflater

class DogListAdapter(val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogListAdapter.DogViewHolder>(),OnClickInterface {


    fun updateDogList(newDogList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogList)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_dog, parent, false)
        val binding = DataBindingUtil.inflate<ItemDogBinding>(inflater,R.layout.item_dog,parent,false)
        return DogViewHolder(binding)

    }

    override fun getItemCount(): Int = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.dog = dogsList[position]
        holder.view.listener = this

        //holder.view.lifespan.text = dogsList[position].lifeSpan
        //holder.view.imageView.loadImage(dogsList[position].imageUrl, getProgressDrawable(holder.view.imageView.context))
    }

    override fun onDogClicked(v: View) {
        val uuid = v.dogId.text.toString().toInt()
        val action = ListFragmentDirections.actionListFragmentToDetailsFragment()
        action.dogUuid = uuid
        Navigation.findNavController(v).navigate(action)
    }

    public class DogViewHolder(val view: ItemDogBinding) : RecyclerView.ViewHolder(view.root) {

    }
}

