package calculator.com.droidconbinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import calculator.com.droidconbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //binding.setName("Vipul");
        binding.setAge(5);

        //binding.setCountries(new String[]{"India", "Australia", "Japan"});
        binding.setListener(new Listener(binding));

        Person person1 = new Person("Vipul123",29,"Thane");
        Person person2 = new Person("Vinay",30,"Thane");
        Person person3 = new Person("Vishal",31,"Thane");
        Person person4 = new Person("Vikas",32,"Thane");
        binding.setPersons(new Person[]{person1,person2,person3,person4});
    }

    public class Listener {

        private ActivityMainBinding binding;

        public Listener(ActivityMainBinding binding) {
            this.binding = binding;
        }

        public void incrementNumber(View view) {
            binding.setAge(binding.getAge() + 1);
        }
    }
}
