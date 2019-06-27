package com.example.shap.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shap.R;
import com.example.shap.adaper.CartAdapter;
import com.example.shap.base.BaseFragment;
import com.example.shap.bean.ShoppingCartBean;
import com.example.shap.interfaces.Api;
import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.contract.CartContracy;
import com.example.shap.presenter.Cart_Presenter;
import com.example.shap.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;


public class CartFragment extends BaseFragment<CartContracy.View,CartContracy.Presenter> implements CartAdapter.CheckInterface,CartAdapter.ModifyCountInterface,CartContracy.View{

    private static final String TAG = "CartFragment";
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.ll)
    RelativeLayout ll;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;
    @BindView(R.id.ck_all)
    CheckBox ckAll;
    @BindView(R.id.tv_show_price)
    TextView tvShowPrice;
    @BindView(R.id.tv_settlement)
    TextView tvSettlement;
    @BindView(R.id.rl_bottom)
    LinearLayout rlBottom;
    @BindView(R.id.tv_bianji)
    TextView tvBianji;

    private List<ShoppingCartBean> shoppingCartBeanList;
    private CartAdapter cartAdapter;
    private double totalPrice = 0.00;// 购买的商品总价
    private int totalCount = 0;// 购买的商品总数量
    private boolean flag = false;

    @Override
    protected CartContracy.Presenter getPresenter() {
        return new Cart_Presenter();
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cartAdapter = new CartAdapter(getContext());
        recyclerView.setAdapter(cartAdapter);
        cartAdapter.setShoppingCartBeanList(shoppingCartBeanList);
        cartAdapter.setModifyCountInterface(this);
        cartAdapter.setCheckInterface(this);
    }

    @Override
    protected void initFragments() {
        shoppingCartBeanList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ShoppingCartBean cartBean = new ShoppingCartBean();
            cartBean.setShoppingName("上档次的T桖");
            cartBean.setDressSize(20);
            cartBean.setId(i);
            cartBean.setPrice(30.6);
            cartBean.setCount(1);
            cartBean.setImageUrl("https://img.alicdn.com/bao/uploaded/i2/TB1YfERKVXXXXanaFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
            shoppingCartBeanList.add(cartBean);
        }
        for (int i = 0; i < 2; i++) {
            ShoppingCartBean cartBean = new ShoppingCartBean();
            cartBean.setShoppingName("瑞士正品夜光男女士手表情侣精钢带男表防水石英学生非天王星机械");
            cartBean.setAttribute("黑白色");
            cartBean.setPrice(89);
            cartBean.setId(i + 2);
            cartBean.setCount(3);
            cartBean.setImageUrl("https://gd1.alicdn.com/imgextra/i1/2160089910/TB2M_NSbB0kpuFjSsppXXcGTXXa_!!2160089910.jpg");
            shoppingCartBeanList.add(cartBean);

        }


    }

    protected void initData() {
//        mPresenter.getData_cart();
    }

    @Override
    public void getData_cart(ShoppingCartBean bean_search) {

    }

    @OnClick({R.id.tv_settlement,R.id.tv_bianji,R.id.ck_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_settlement:
                lementOnder();
                break;
            case R.id.tv_bianji:
                flag = !flag;
                if (flag) {
                    tvBianji.setText("完成");
                    cartAdapter.isShow(false);
                } else {
                    tvBianji.setText("编辑");
                    cartAdapter.isShow(true);
                }
                break;
            case R.id.ck_all:
                if (shoppingCartBeanList.size() != 0) {
                    if (ckAll.isChecked()) {
                        for (int i = 0; i < shoppingCartBeanList.size(); i++) {
                            shoppingCartBeanList.get(i).setChoosed(true);
                        }
                        cartAdapter.notifyDataSetChanged();
                    } else {
                        for (int i = 0; i < shoppingCartBeanList.size(); i++) {
                            shoppingCartBeanList.get(i).setChoosed(false);
                        }
                        cartAdapter.notifyDataSetChanged();
                    }
                }
                statistics();
                break;
        }
    }

    /**
     * 结算订单、支付
     */
    private void lementOnder() {
        //选中的需要提交的商品清单
        for (ShoppingCartBean bean:shoppingCartBeanList ){
            boolean choosed = bean.isChoosed();
            if (choosed){
                String shoppingName = bean.getShoppingName();
                int count = bean.getCount();
                double price = bean.getPrice();
                int size = bean.getDressSize();
                String attribute = bean.getAttribute();
                int id = bean.getId();
                Log.d(TAG,id+"----id---"+shoppingName+"---"+count+"---"+price+"--size----"+size+"--attr---"+attribute);
            }
        }
        ToastUtil.showLong("总价："+totalPrice);

        //跳转到支付界面
    }

    /**
     * 单选
     * @param position  组元素位置
     * @param isChecked 组元素选中与否
     */
    @Override
    public void checkGroup(int position, boolean isChecked) {
        shoppingCartBeanList.get(position).setChoosed(isChecked);
        if (isAllCheck())
            ckAll.setChecked(true);
        else
            ckAll.setChecked(false);
        cartAdapter.notifyDataSetChanged();
        statistics();
    }
    /**
     * 遍历list集合
     * @return
     */
    private boolean isAllCheck() {

        for (ShoppingCartBean group : shoppingCartBeanList) {
            if (!group.isChoosed())
                return false;
        }
        return true;
    }

    /**
     * 统计操作
     * 1.先清空全局计数器<br>
     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作
     * 3.给底部的textView进行数据填充
     */
    public void statistics() {
        totalCount = 0;
        totalPrice = 0.00;
        for (int i = 0; i < shoppingCartBeanList.size(); i++) {
            ShoppingCartBean shoppingCartBean = shoppingCartBeanList.get(i);
            if (shoppingCartBean.isChoosed()) {
                totalCount++;
                totalPrice += shoppingCartBean.getPrice() * shoppingCartBean.getCount();
            }
        }
        tvShowPrice.setText("合计:" + totalPrice);
        tvSettlement.setText("结算(" + totalCount + ")");
    }


    /**
     * 增加
     * @param position      组元素位置
     * @param showCountView 用于展示变化后数量的View
     * @param isChecked     子元素选中与否
     */
    @Override
    public void doIncrease(int position, View showCountView, boolean isChecked) {
        ShoppingCartBean shoppingCartBean = shoppingCartBeanList.get(position);
        int currentCount = shoppingCartBean.getCount();
        currentCount++;
        shoppingCartBean.setCount(currentCount);
        ((TextView) showCountView).setText(currentCount + "");
        cartAdapter.notifyDataSetChanged();
        statistics();
    }

    /**
     * 删减
     *
     * @param position      组元素位置
     * @param showCountView 用于展示变化后数量的View
     * @param isChecked     子元素选中与否
     */
    @Override
    public void doDecrease(int position, View showCountView, boolean isChecked) {
        ShoppingCartBean shoppingCartBean = shoppingCartBeanList.get(position);
        int currentCount = shoppingCartBean.getCount();
        if (currentCount == 1) {
            return;
        }
        currentCount--;
        shoppingCartBean.setCount(currentCount);
        ((TextView) showCountView).setText(currentCount + "");
        cartAdapter.notifyDataSetChanged();
        statistics();
    }

    /**
     * 删除
     *
     * @param position
     */
    @Override
    public void childDelete(int position) {
        shoppingCartBeanList.remove(position);
        cartAdapter.notifyDataSetChanged();
        statistics();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cart;
    }
}
