/*
 * Copyright (C) 2014 VenomVendor <info@VenomVendor.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package vee.android.sample.recyclerview;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListAdapterHolder extends RecyclerView.Adapter<ListAdapterHolder.ViewHolder> {

    private final FragmentActivity mActivity;
    private List<UserDetails> mUserDetails = new ArrayList<UserDetails>();

    public ListAdapterHolder(FragmentActivity mActivity) {
        this.mActivity = mActivity;
        createUserDetails();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.single_list_item, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder , int position) {
        holder.vId.setText("ID: " + mUserDetails.get(position).getId());
        holder.vName.setText("Name: " + mUserDetails.get(position).getName());
        holder.vSex.setText("Sex: " + mUserDetails.get(position).getSex());
        holder.vAge.setText("Age: " + mUserDetails.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return mUserDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView vName, vSex, vId, vAge;

        public ViewHolder(View view) {
            super(view);
            vId = (TextView) view.findViewById(R.id.list_id);
            vName = (TextView) view.findViewById(R.id.list_name);
            vSex = (TextView) view.findViewById(R.id.list_sex);
            vAge = (TextView) view.findViewById(R.id.list_age);
        }

    }

    /* ==========This Part is not necessary========= */

    /**
     * Create Random Users
     */
    private void createUserDetails() {
        for (int i = 0; i < 100; i++) {
            UserDetails mDetails = new UserDetails();
            mDetails.setId(i);
            mDetails.setName("Name " + i);
            mDetails.setSex((i % 2) == 0 ? "M" : "F");
            mDetails.setAge(randInt(14, 50));
            mUserDetails.add(mDetails);
        }
    }

    /*
     * Snippet from http://stackoverflow.com/a/363692/1008278
     */
    public static int randInt(int min , int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    /* ==========This Part is not necessary========= */

}
