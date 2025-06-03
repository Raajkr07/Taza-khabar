package com.example.tazakhabar.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tazakhabar.databinding.FragmentHeadlinesBinding
import com.example.tazakhabar.repository.NewsRepository
import com.example.tazakhabar.ui.adapter.NewsAdapter
import com.example.tazakhabar.viewmodel.NewsViewModel
import com.example.tazakhabar.viewmodel.NewsViewModelFactory
import androidx.navigation.fragment.findNavController
import com.example.tazakhabar.R

class HeadlinesFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter: NewsAdapter
    private var _binding: FragmentHeadlinesBinding? = null
    private val binding get() = _binding!!

    private val apiKey = "dc0b34773a334b6d99ab0cc5aed0f37b"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeadlinesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        val repository = NewsRepository()
        val viewModelFactory = NewsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]

        viewModel.getTopHeadlines(apiKey)

        // 🔴 Top headlines observer
        viewModel.newsResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    adapter.submitList(it.articles)
                }
            } else {
                Toast.makeText(context, "Failed: ${response.message()}", Toast.LENGTH_SHORT).show()
            }
        }

        // 🔍 Search
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    viewModel.searchNews(query, apiKey)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?) = false
        })

        viewModel.searchResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                adapter.submitList(response.body()?.articles ?: emptyList())
            }
        }

        // 🔘 Category Buttons Setup
        val categories = mapOf(
            binding.btnHome to "general",
            binding.btnWorld to "world",
            binding.btnSports to "sports",
            binding.btnSciTech to "science",
            binding.btnEntertainment to "entertainment",
            binding.btnFood to "food",
            binding.btnBusiness to "business",
            binding.btnHealth to "health",
            binding.btnTech to "technology"
        )

        categories.forEach { (button, category) ->
            button.setOnClickListener {
                viewModel.getNewsByCategory(category, apiKey)
                Toast.makeText(requireContext(), "Loading $category news", Toast.LENGTH_SHORT).show()
            }
        }

        // 📦 Category response observer
        viewModel.categoryResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                adapter.submitList(response.body()?.articles ?: emptyList())
            } else {
                Toast.makeText(context, "Category Fetch Failed: ${response.message()}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = NewsAdapter { article ->
            val bundle = Bundle().apply {
                putString("url", article.url)
            }
            findNavController().navigate(R.id.action_headlinesFragment_to_newsDetailFragment, bundle)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
