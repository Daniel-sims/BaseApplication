package com.sims.daniel.baseapplication.features.list;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sims.daniel.baseapplication.R;
import com.sims.daniel.baseapplication.data.models.Message;
import com.sims.daniel.baseapplication.databinding.FragmentListBinding;
import com.sims.daniel.baseapplication.features.application.base.BaseCallbackFragment;
import com.sims.daniel.baseapplication.features.list.interfaces.IListActivityCallback;
import com.sims.daniel.baseapplication.utils.Utilities;
import com.sims.daniel.baseapplication.utils.adapters.MessageAdapter;

public class ListFragment extends BaseCallbackFragment<ListViewModel, IListActivityCallback> {

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    private FragmentListBinding mFragmentListBinding;
    private MessageAdapter mMessageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_list, container, false);

        getAppComponent().inject(this);

        initViewModel(ListViewModel.class);
        initActivityCallback(IListActivityCallback.class);

        initMessageRecyclerView();

        initToolbar();
        initOnClick();
        initObservers();

        return mFragmentListBinding.getRoot();
    }

    private void initToolbar() {
        Context context = getContext();
        if (context != null) {
            mFragmentListBinding.fragmentListToolbar.setNavigationIcon(Utilities.getAttributeTintedDrawable(
                    getContext(),
                    R.attr.NavigationUpArrow,
                    R.attr.ListFragmentNavigationIconColor));

            mFragmentListBinding.fragmentListToolbar.setNavigationOnClickListener(view -> onBackPressed());
        }
    }

    private void initOnClick() {
        mFragmentListBinding.fragmentListAddMessageButton.setOnClickListener(view -> {
            if (mFragmentListBinding.fragmentListMessageEditText.getText() != null
                    && !TextUtils.isEmpty(mFragmentListBinding.fragmentListMessageEditText
                    .getText().toString())) {
                addNewMessage(mFragmentListBinding.fragmentListMessageEditText.getText().toString());
            }
        });
    }

    private void initObservers() {
        getViewModel().getMessages().observe(getViewLifecycleOwner(),
                messages -> {
                    if(!Utilities.isNullOrEmpty(messages) && mMessageAdapter != null) {
                        mMessageAdapter.updateData(messages);
                    }
                });
    }

    private void initMessageRecyclerView() {
        mMessageAdapter = new MessageAdapter(MessageAdapter.MessageAdapterViewTypes.VERTICAL);
        mFragmentListBinding.fragmentListMessagesRecyclerView.setAdapter(mMessageAdapter);
    }

    private void addNewMessage(@Nullable String messageText) {
        if (!TextUtils.isEmpty(messageText)) {
            Message message = new Message();
            message.setMessage(messageText);

            getViewModel().insertMessage(message);
        }
    }
}
