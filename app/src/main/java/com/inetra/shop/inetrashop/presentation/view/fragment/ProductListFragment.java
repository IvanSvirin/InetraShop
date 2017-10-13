package com.inetra.shop.inetrashop.presentation.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;

import com.inetra.shop.inetrashop.R;
import com.inetra.shop.inetrashop.domain.di.components.ProductComponent;
import com.inetra.shop.inetrashop.presentation.model.Category;
import com.inetra.shop.inetrashop.presentation.model.ProductListModel;
import com.inetra.shop.inetrashop.presentation.presenter.ProductListPresenter;
import com.inetra.shop.inetrashop.presentation.view.ProductListView;
import com.inetra.shop.inetrashop.presentation.view.adapter.ProductsAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductListFragment extends BaseFragment implements ProductListView {

    public interface ProductListListener {
        void onProductClicked(final ProductListModel productListModel);
    }

    @Inject
    ProductListPresenter productListPresenter;
    @Inject
    ProductsAdapter productsAdapter;
    private List<Map<String, String>> groupData;
    private List<ArrayList<Map<String, ProductListModel>>> childData;
    @Bind(R.id.elv_products)
    ExpandableListView elv_products;
    @Bind(R.id.rl_progress)
    RelativeLayout rl_progress;
    @Bind(R.id.rl_retry)
    RelativeLayout rl_retry;
    @Bind(R.id.bt_retry)
    Button bt_retry;
    private ProductListListener productListListener;

    public ProductListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ProductListListener) {
            this.productListListener = (ProductListListener) activity;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(ProductComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_product_list, container, false);
        ButterKnife.bind(this, fragmentView);
        setupExpandableListView();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.productListPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadProductList();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.productListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.productListPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.productListPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.productListListener = null;
    }

    @Override
    public void showLoading() {
        this.rl_progress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rl_retry.setVisibility(View.GONE);
    }

    public void renderProductList(Collection<ProductListModel> productModelCollection) {
        if (productModelCollection != null) {
            prepareData(productModelCollection);
            this.productsAdapter.setProductsCollection(groupData, childData);
        }
    }

    public void viewProduct(ProductListModel productListModel) {
        if (this.productListListener != null) {
            this.productListListener.onProductClicked(productListModel);
        }
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    private void setupExpandableListView() {
        this.elv_products.setAdapter(productsAdapter);
        this.elv_products.setOnChildClickListener((expandableListView, view, groupPosition, childPosition, id) -> {
            ProductListFragment.this.productListPresenter.onProductClicked(childData.get(groupPosition).get(childPosition).get("childName"));
            return true;
        });
    }

    private void loadProductList() {
        this.productListPresenter.initialize();
    }

    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        ProductListFragment.this.loadProductList();
    }

    private void prepareData(Collection<ProductListModel> productsCollection) {
        List<String> groupsArray = new ArrayList<>();
        List<ProductListModel> booksArray = new ArrayList<>();
        List<ProductListModel> disksArray = new ArrayList<>();

        groupsArray.add(Category.Books.toString());
        groupsArray.add(Category.Disks.toString());
        for (ProductListModel productListModel : productsCollection) {
            if (productListModel.getCategory().equals(Category.Books.toString()))
                booksArray.add(productListModel);
            if (productListModel.getCategory().equals(Category.Disks.toString()))
                disksArray.add(productListModel);
        }

        Map<String, String> groupMap;
        ArrayList<Map<String, String>> groupDataList = new ArrayList<>();
        for (String group : groupsArray) {
            groupMap = new HashMap<>();
            groupMap.put("groupName", group);
            groupDataList.add(groupMap);
        }
        groupData = groupDataList;

        ArrayList<ArrayList<Map<String, ProductListModel>>> сhildDataList = new ArrayList<>();
        Map<String, ProductListModel> childMap;
        ArrayList<Map<String, ProductListModel>> сhildDataItemList = new ArrayList<>();
        for (ProductListModel productListModel : booksArray) {
            childMap = new HashMap<>();
            childMap.put("childName", productListModel);
            сhildDataItemList.add(childMap);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (ProductListModel productListModel : disksArray) {
            childMap = new HashMap<>();
            childMap.put("childName", productListModel);
            сhildDataItemList.add(childMap);
        }
        сhildDataList.add(сhildDataItemList);
        childData = сhildDataList;
    }
}
