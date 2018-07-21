/*
 * Copyright (c) 2017 Selva.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.bacon.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    String[] parent = new String[]{"AAAAA", "BBBBB", "CCCCC"};
    String[] child = new String[]{"MMMMMMMMMM", "NNNNNNNNNNN", "PPPPPPPPPPP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpAdapter();
    }

    private void setUpAdapter() {

        expandableListView = (ExpandableListView) findViewById(R.id.expandible_listview);
        ExpandviewListAdapter expandviewListAdapterAdapter = new ExpandviewListAdapter(this, parent, child);
        expandableListView.setAdapter(expandviewListAdapterAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    expandableListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });
    }
}
