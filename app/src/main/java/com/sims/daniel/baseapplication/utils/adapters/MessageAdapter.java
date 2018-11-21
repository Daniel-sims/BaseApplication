package com.sims.daniel.baseapplication.utils.adapters;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sims.daniel.baseapplication.data.models.Message;
import com.sims.daniel.baseapplication.databinding.ItemMessageVerticalBinding;
import com.sims.daniel.baseapplication.utils.Utilities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

import static com.sims.daniel.baseapplication.utils.adapters.MessageAdapter.MessageAdapterViewTypes.VERTICAL;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>  {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ VERTICAL })
    public @interface MessageAdapterViewTypes {
        int VERTICAL = 1;
    }

    private List<Message> mMessages = new ArrayList<>();

    @MessageAdapterViewTypes
    private int mMessageAdapterViewType;

    public MessageAdapter(@MessageAdapterViewTypes int messageAdapterViewType) {
        mMessageAdapterViewType = messageAdapterViewType;
    }

    public void updateData(List<Message> messages) {
        mMessages.clear();
        mMessages.addAll(messages);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        if (viewType == VERTICAL) {
            return new MessageAdapter.MessageViewHolder(
                    ItemMessageVerticalBinding.inflate(
                            LayoutInflater.from(viewGroup.getContext()),
                            viewGroup,
                            false));
        }

        /*
            onCreateViewHolder cannot return NULL, so Vertical is chosen as the default style.
         */
        return new MessageAdapter.MessageViewHolder(
                ItemMessageVerticalBinding.inflate(
                        LayoutInflater.from(viewGroup.getContext()),
                        viewGroup,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int position) {
        if(!Utilities.isNullOrEmpty(mMessages)) {
            Message message = mMessages.get(position);

            if(message != null) {
                switch(messageViewHolder.getItemViewType()) {
                    case VERTICAL:
                        ItemMessageVerticalBinding itemMessageVerticalBinding =
                                messageViewHolder.mItemMessageVerticalBinding;

                        itemMessageVerticalBinding.itemMessageVerticalText.setText(message.getMessage());
                        break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mMessageAdapterViewType;
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {

        private final ItemMessageVerticalBinding mItemMessageVerticalBinding;

        MessageViewHolder(final ItemMessageVerticalBinding itemMessageVerticalBinding) {
            super(itemMessageVerticalBinding.getRoot());
            mItemMessageVerticalBinding = itemMessageVerticalBinding;
        }
    }
}
