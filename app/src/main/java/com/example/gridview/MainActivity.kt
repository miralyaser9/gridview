package com.example.gridview

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.coroutines.NonDisposableHandle.parent

class MainActivity : AppCompatActivity() {

    lateinit var gridView:GridView

    var images:ArrayList<Int>? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          images= ArrayList()





          images!!.add(R.drawable.dog)
          images!!.add(R.drawable.doli)
          images!!.add(R.drawable.gira)
          images!!.add(R.drawable.elephant)
          images!!.add(R.drawable.lion)
          images!!.add(R.drawable.mira)
          images!!.add(R.drawable.monkey)
          images!!.add(R.drawable.panda)
          images!!.add(R.drawable.pingo)


        gridView=findViewById(R.id.gridView)

         val gridAdapter=GridAdapter(images!!,this)
          gridView.adapter=gridAdapter





        gridView.setOnItemClickListener(object :AdapterView.OnItemClickListener{
           override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {


              /* val my_image=images!![position]

               gridAdapter.images.remove(my_image)
               gridAdapter.notifyDataSetChanged()*/
               val alert=AlertDialog.Builder(this@MainActivity)
               val inflater=layoutInflater

               var view=inflater.inflate(R.layout.delete,null)
               alert.setView(view)
               alert.setTitle("do you want to delete")
               val alertDialog=alert.create()

               alertDialog.show()



           }

       })


    }
}
class GridAdapter( var images:ArrayList<Int>,val context: Context):BaseAdapter(){

    lateinit var image_view:ImageView


    //val images= arrayOf(R.drawable.dog,R.drawable.doli,R.drawable.elephant,R.drawable.gira,R.drawable.mira,R.drawable.monkey,R.drawable.panda,R.drawable.pingo,R.drawable.lion)




    override fun getCount(): Int {

        return images.size
    }

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {

       return images[p0].toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {



         var view=LayoutInflater.from(context).inflate(R.layout.single_row,p2,false)

        image_view=view.findViewById(R.id.image_view)
        image_view.setImageResource(images[p0])
        return view



    }
}