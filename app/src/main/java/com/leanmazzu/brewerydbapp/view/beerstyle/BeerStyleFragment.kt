package com.leanmazzu.brewerydbapp.view.beerstyle

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leanmazzu.brewerydbapp.R
import com.leanmazzu.brewerydbapp.R.id.loadingView
import com.leanmazzu.brewerydbapp.R.id.recyclerView
import com.leanmazzu.brewerydbapp.contract.BeerStyleListContract
import com.leanmazzu.brewerydbapp.core.view.BaseFragment
import com.leanmazzu.brewerydbapp.data.remote.Style
import kotlinx.android.synthetic.main.fragment_beer_style_list.*
import javax.inject.Inject

class BeerStyleFragment : BaseFragment(), BeerStyleRecyclerViewAdapter.OnListFragmentInteractionListener, BeerStyleListContract.View {

    //MVP
    @Inject
    lateinit var presenter: BeerStyleListContract.Presenter

    private lateinit var adapter: BeerStyleRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_beer_style_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL))
        adapter = BeerStyleRecyclerViewAdapter(this)
        recyclerView.adapter = adapter
        presenter.loadStyles()
    }

    override fun onDetach() {
        super.onDetach()
        presenter.onDetach()
    }

    override fun onListFragmentInteraction(item: Style) {

    }

    override fun onLoadingStyles() {
        loadingView.visibility = View.VISIBLE
    }

    override fun onFinishLoadingStyles(beerStyles: List<Style>) {
        loadingView.visibility = View.GONE
        adapter.setItems(beerStyles)
    }

    override fun onErrorLoadingStyles(errorMessage: String) {
        loadingView.visibility = View.GONE
    }

    override fun onConnectionErrorLoadingStyles() {
        loadingView.visibility = View.GONE
    }

    companion object {

        fun newInstance(): BeerStyleFragment {
            val fragment = BeerStyleFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
