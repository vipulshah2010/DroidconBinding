package calculator.com.droidconbinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import calculator.com.droidconbinding.databinding.PersonRowItemBinding;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private final Person[] persons;

    public PersonAdapter(Person[] persons) {
        this.persons = persons;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PersonRowItemBinding personRowItemBinding = PersonRowItemBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PersonViewHolder(personRowItemBinding);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.binding.setPerson(persons[position]);
    }

    @Override
    public int getItemCount() {
        return persons.length;
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        final PersonRowItemBinding binding;

        public PersonViewHolder(PersonRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
