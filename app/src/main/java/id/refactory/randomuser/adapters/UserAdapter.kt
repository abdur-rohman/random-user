package id.refactory.randomuser.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.refactory.randomuser.R
import id.refactory.randomuser.models.ResultsItem
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var list: List<ResultsItem> = listOf()
        set(value) {
            field = value

            notifyDataSetChanged()
        }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(resultsItem: ResultsItem) {
            with(resultsItem) {
                view.tvName.text = "${name.title}. ${name.first} ${name.last}"

                Glide.with(view)
                    .load(picture.large)
                    .placeholder(R.drawable.ic_placeholder)
                    .centerCrop()
                    .apply { circleCrop() }
                    .error(R.drawable.ic_warning).into(view.ivUser)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount() = list.size
}