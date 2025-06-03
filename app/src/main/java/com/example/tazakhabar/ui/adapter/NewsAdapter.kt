package com.example.tazakhabar.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tazakhabar.R
import com.example.tazakhabar.databinding.ItemArticleBinding
import com.example.tazakhabar.model.Article
import android.util.Log

class NewsAdapter(
    private val onItemClick: (Article) -> Unit
) : ListAdapter<Article, NewsAdapter.NewsViewHolder>(ArticleDiffCallback()) {

    inner class NewsViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.tvTitle.text = article.title
            binding.tvDescription.text = article.description

            val imageUrl = article.urlToImage
            Log.d("ImageURL", "URL: $imageUrl")

            if (!imageUrl.isNullOrEmpty()) {
                Glide.with(binding.ivArticle.context)
                    .load(imageUrl)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.image_not_found)
                    .centerCrop()
                    .into(binding.ivArticle)
            } else {
                binding.ivArticle.setImageResource(R.drawable.image_not_found)
            }

            // 👇 Handle item click
            binding.root.setOnClickListener {
                onItemClick(article)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
