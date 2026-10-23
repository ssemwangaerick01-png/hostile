package com.example.hostelfinder;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity {

    // ==========================================
    // UI ELEMENTS
    // ==========================================

    private ImageButton backButton;
    private ImageButton clearSearch;

    private EditText searchInput;

    private Spinner districtSpinner;
    private Spinner areaSpinner;
    private Spinner universitySpinner;
    private Spinner sortSpinner;

    private Button filterButton;
    private Button moreFiltersButton;

    private TextView resultsCount;

    private RecyclerView hostelResults;

    private LinearLayout noResultsLayout;


    // ==========================================
    // DATA
    // ==========================================

    private final List<Hostel> allHostels = new ArrayList<>();
    private final List<Hostel> filteredHostels = new ArrayList<>();

    private HostelAdapter hostelAdapter;


    // ==========================================
    // FILTER VARIABLES
    // ==========================================

    private String selectedDistrict = "All Districts";
    private String selectedArea = "All Areas";
    private String selectedUniversity = "All Universities";
    private String selectedSort = "Recommended";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hostel_search);

        // Initialize views
        initializeViews();

        // Setup RecyclerView
        setupRecyclerView();

        // Setup Spinners
        setupSpinners();

        // Load sample hostels
        loadHostelData();

        // Setup button actions
        setupClickListeners();

        // Setup search field
        setupSearch();

        // Display initial results
        filteredHostels.addAll(allHostels);
        updateResults();
    }


    // ==========================================
    // INITIALIZE VIEWS
    // ==========================================

    private void initializeViews() {

        backButton = findViewById(R.id.backbutton);

        clearSearch = findViewById(R.id.clear_search);

        searchInput = findViewById(R.id.search_input);

        districtSpinner = findViewById(R.id.district_spinner);

        areaSpinner = findViewById(R.id.area_spinner);

        universitySpinner = findViewById(R.id.university_spinner);

        sortSpinner = findViewById(R.id.sort_spinner);

        filterButton = findViewById(R.id.filter_button);

        moreFiltersButton = findViewById(R.id.more_filters_button);

        resultsCount = findViewById(R.id.results_count);

        hostelResults = findViewById(R.id.hostel_results);

        noResultsLayout = findViewById(R.id.no_results_layout);
    }


    // ==========================================
    // RECYCLERVIEW
    // ==========================================

    private void setupRecyclerView() {

        hostelResults.setLayoutManager(
                new LinearLayoutManager(this)
        );

        hostelAdapter = new HostelAdapter(filteredHostels);

        hostelResults.setAdapter(hostelAdapter);
    }


    // ==========================================
    // SPINNERS
    // ==========================================

    private void setupSpinners() {

        // Districts
        String[] districts = {
                "All Districts",
                "Kampala",
                "Wakiso",
                "Mukono"
        };

        ArrayAdapter<String> districtAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        districts
                );

        districtAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        districtSpinner.setAdapter(districtAdapter);


        // Areas
        String[] areas = {
                "All Areas",
                "Kisaasi",
                "Ntinda",
                "Banda",
                "Kyambogo",
                "Kireka",
                "Kabalagala",
                "Makerere"
        };

        ArrayAdapter<String> areaAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        areas
                );

        areaAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        areaSpinner.setAdapter(areaAdapter);


        // Universities
        String[] universities = {
                "All Universities",
                "Kyambogo University",
                "Makerere University",
                "Makerere University Business School",
                "Uganda Christian University",
                "Kampala International University"
        };

        ArrayAdapter<String> universityAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        universities
                );

        universityAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        universitySpinner.setAdapter(universityAdapter);


        // Sorting
        String[] sortingOptions = {
                "Recommended",
                "Price: Low to High",
                "Price: High to Low",
                "Highest Rated",
                "Most Available"
        };

        ArrayAdapter<String> sortAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        sortingOptions
                );

        sortAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        sortSpinner.setAdapter(sortAdapter);
    }


    // ==========================================
    // SAMPLE HOSTEL DATA
    // ==========================================

    private void loadHostelData() {

        allHostels.clear();

        allHostels.add(
                new Hostel(
                        "Sunrise Hostel",
                        "Kisaasi",
                        "Kampala",
                        "Kyambogo University",
                        450000,
                        4.5,
                        12
                )
        );

        allHostels.add(
                new Hostel(
                        "Royal Gardens Hostel",
                        "Ntinda",
                        "Kampala",
                        "Makerere University",
                        500000,
                        4.2,
                        8
                )
        );

        allHostels.add(
                new Hostel(
                        "Campus View Hostel",
                        "Banda",
                        "Kampala",
                        "Kyambogo University",
                        350000,
                        4.0,
                        20
                )
        );

        allHostels.add(
                new Hostel(
                        "Green Valley Hostel",
                        "Kireka",
                        "Wakiso",
                        "Kyambogo University",
                        300000,
                        4.3,
                        15
                )
        );

        allHostels.add(
                new Hostel(
                        "University Heights",
                        "Makerere",
                        "Kampala",
                        "Makerere University",
                        550000,
                        4.7,
                        6
                )
        );

        allHostels.add(
                new Hostel(
                        "Comfort Homes",
                        "Kabalagala",
                        "Kampala",
                        "Kampala International University",
                        400000,
                        4.1,
                        10
                )
        );
    }


    // ==========================================
    // SEARCH
    // ==========================================

    private void setupSearch() {

        searchInput.addTextChangedListener(
                new TextWatcher() {

                    @Override
                    public void beforeTextChanged(
                            CharSequence s,
                            int start,
                            int count,
                            int after
                    ) {
                    }


                    @Override
                    public void onTextChanged(
                            CharSequence s,
                            int start,
                            int before,
                            int count
                    ) {

                        if (s.length() > 0) {

                            clearSearch.setVisibility(
                                    View.VISIBLE
                            );

                        } else {

                            clearSearch.setVisibility(
                                    View.GONE
                            );
                        }
                    }


                    @Override
                    public void afterTextChanged(
                            Editable s
                    ) {
                    }
                }
        );
    }


    // ==========================================
    // CLICK LISTENERS
    // ==========================================

    private void setupClickListeners() {

        // Back button
        backButton.setOnClickListener(v -> finish());


        // Clear search
        clearSearch.setOnClickListener(v -> {

            searchInput.setText("");

            searchHostels();
        });


        // Search button
        filterButton.setOnClickListener(v -> {

            searchHostels();
        });


        // More filters
        moreFiltersButton.setOnClickListener(v -> {

            showMoreFiltersDialog();
        });


        // District
        districtSpinner.setOnItemSelectedListener(
                new android.widget.AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            android.widget.AdapterView<?> parent,
                            View view,
                            int position,
                            long id
                    ) {

                        selectedDistrict =
                                parent.getItemAtPosition(position)
                                        .toString();
                    }


                    @Override
                    public void onNothingSelected(
                            android.widget.AdapterView<?> parent
                    ) {
                    }
                }
        );


        // Area
        areaSpinner.setOnItemSelectedListener(
                new android.widget.AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            android.widget.AdapterView<?> parent,
                            View view,
                            int position,
                            long id
                    ) {

                        selectedArea =
                                parent.getItemAtPosition(position)
                                        .toString();
                    }


                    @Override
                    public void onNothingSelected(
                            android.widget.AdapterView<?> parent
                    ) {
                    }
                }
        );


        // University
        universitySpinner.setOnItemSelectedListener(
                new android.widget.AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            android.widget.AdapterView<?> parent,
                            View view,
                            int position,
                            long id
                    ) {

                        selectedUniversity =
                                parent.getItemAtPosition(position)
                                        .toString();
                    }


                    @Override
                    public void onNothingSelected(
                            android.widget.AdapterView<?> parent
                    ) {
                    }
                }
        );


        // Sorting
        sortSpinner.setOnItemSelectedListener(
                new android.widget.AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            android.widget.AdapterView<?> parent,
                            View view,
                            int position,
                            long id
                    ) {

                        selectedSort =
                                parent.getItemAtPosition(position)
                                        .toString();

                        sortResults();
                    }


                    @Override
                    public void onNothingSelected(
                            android.widget.AdapterView<?> parent
                    ) {
                    }
                }
        );
    }


    // ==========================================
    // SEARCH HOSTELS
    // ==========================================

    private void searchHostels() {

        String searchText =
                searchInput.getText()
                        .toString()
                        .trim()
                        .toLowerCase(Locale.ROOT);


        filteredHostels.clear();


        for (Hostel hostel : allHostels) {

            boolean matchesSearch =

                    searchText.isEmpty()

                            ||

                            hostel.name
                                    .toLowerCase(Locale.ROOT)
                                    .contains(searchText)

                            ||

                            hostel.area
                                    .toLowerCase(Locale.ROOT)
                                    .contains(searchText)

                            ||

                            hostel.district
                                    .toLowerCase(Locale.ROOT)
                                    .contains(searchText);


            boolean matchesDistrict =

                    selectedDistrict.equals("All Districts")

                            ||

                            hostel.district.equals(selectedDistrict);


            boolean matchesArea =

                    selectedArea.equals("All Areas")

                            ||

                            hostel.area.equals(selectedArea);


            boolean matchesUniversity =

                    selectedUniversity.equals("All Universities")

                            ||

                            hostel.university.equals(selectedUniversity);


            if (
                    matchesSearch
                            &&
                            matchesDistrict
                            &&
                            matchesArea
                            &&
                            matchesUniversity
            ) {

                filteredHostels.add(hostel);
            }
        }


        sortResults();
    }


    // ==========================================
    // SORT RESULTS
    // ==========================================

    private void sortResults() {

        if (filteredHostels == null) {
            return;
        }


        switch (selectedSort) {

            case "Price: Low to High":

                filteredHostels.sort(
                        (a, b) ->
                                Integer.compare(
                                        a.price,
                                        b.price
                                )
                );

                break;


            case "Price: High to Low":

                filteredHostels.sort(
                        (a, b) ->
                                Integer.compare(
                                        b.price,
                                        a.price
                                )
                );

                break;


            case "Highest Rated":

                filteredHostels.sort(
                        (a, b) ->
                                Double.compare(
                                        b.rating,
                                        a.rating
                                )
                );

                break;


            case "Most Available":

                filteredHostels.sort(
                        (a, b) ->
                                Integer.compare(
                                        b.availableRooms,
                                        a.availableRooms
                                )
                );

                break;
        }


        if (hostelAdapter != null) {

            hostelAdapter.notifyDataSetChanged();
        }


        updateResults();
    }


    // ==========================================
    // UPDATE RESULTS
    // ==========================================

    private void updateResults() {

        int count = filteredHostels.size();


        resultsCount.setText(
                count + (count == 1
                        ? " Hostel Found"
                        : " Hostels Found")
        );


        if (count == 0) {

            noResultsLayout.setVisibility(
                    View.VISIBLE
            );

            hostelResults.setVisibility(
                    View.GONE
            );

        } else {

            noResultsLayout.setVisibility(
                    View.GONE
            );

            hostelResults.setVisibility(
                    View.VISIBLE
            );
        }


        if (hostelAdapter != null) {

            hostelAdapter.notifyDataSetChanged();
        }
    }


    // ==========================================
    // MORE FILTERS
    // ==========================================

    private void showMoreFiltersDialog() {

        String[] filters = {

                "Any Price",

                "Under UGX 300,000",

                "UGX 300,000 - 500,000",

                "UGX 500,000 - 700,000",

                "Above UGX 700,000"
        };


        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);


        builder.setTitle("More Filters");


        builder.setSingleChoiceItems(
                filters,
                0,
                (dialog, which) -> {

                    Toast.makeText(
                            SearchActivity.this,
                            "Filter selected: " + filters[which],
                            Toast.LENGTH_SHORT
                    ).show();

                    dialog.dismiss();
                }
        );


        builder.setNegativeButton(
                "Cancel",
                null
        );


        builder.show();
    }


    // ==========================================
    // HOSTEL MODEL
    // ==========================================

    public static class Hostel {

        String name;
        String area;
        String district;
        String university;

        int price;
        int availableRooms;

        double rating;


        public Hostel(
                String name,
                String area,
                String district,
                String university,
                int price,
                double rating,
                int availableRooms
        ) {

            this.name = name;
            this.area = area;
            this.district = district;
            this.university = university;
            this.price = price;
            this.rating = rating;
            this.availableRooms = availableRooms;
        }
    }


    // ==========================================
    // RECYCLERVIEW ADAPTER
    // ==========================================

    public class HostelAdapter
            extends RecyclerView.Adapter<HostelAdapter.HostelViewHolder> {


        private final List<Hostel> hostels;


        public HostelAdapter(List<Hostel> hostels) {

            this.hostels = hostels;
        }


        @Override
        public HostelViewHolder onCreateViewHolder(
                ViewGroup parent,
                int viewType
        ) {

            View view =
                    LayoutInflater.from(parent.getContext())
                            .inflate(
                                    android.R.layout.simple_list_item_2,
                                    parent,
                                    false
                            );

            return new HostelViewHolder(view);
        }


        @Override
        public void onBindViewHolder(
                HostelViewHolder holder,
                int position
        ) {

            Hostel hostel =
                    hostels.get(position);


            holder.title.setText(
                    hostel.name
            );


            holder.subtitle.setText(
                    "📍 " +
                            hostel.area +
                            ", " +
                            hostel.district +
                            "   •   ⭐ " +
                            hostel.rating +
                            "\nUGX " +
                            String.format(
                                    Locale.US,
                                    "%,d",
                                    hostel.price
                            ) +
                            " / semester   •   " +
                            hostel.availableRooms +
                            " rooms available"
            );


            holder.itemView.setOnClickListener(v -> {

                Toast.makeText(
                        SearchActivity.this,
                        "Selected: " + hostel.name,
                        Toast.LENGTH_SHORT
                ).show();

                /*
                 * Later you can open:
                 *
                 * HostelDetailsActivity
                 *
                 * and pass the hostel ID.
                 */
            });
        }


        @Override
        public int getItemCount() {

            return hostels.size();
        }


        class HostelViewHolder
                extends RecyclerView.ViewHolder {

            TextView title;
            TextView subtitle;


            HostelViewHolder(View itemView) {

                super(itemView);

                title =
                        itemView.findViewById(
                                android.R.id.text1
                        );

                subtitle =
                        itemView.findViewById(
                                android.R.id.text2
                        );
            }
        }
    }
}