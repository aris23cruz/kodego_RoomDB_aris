package com.kodego.inventory.app.roomdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodego.inventory.app.roomdemo.databinding.RawItemBinding


class EmployeeAdapter(var employeeModel: MutableList<Employee>): RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    var onItemDelete : ((Employee, Int) -> Unit) ? = null
    var onUpdate : ((Employee, Int) -> Unit) ? = null

    inner class EmployeeViewHolder(var binding: RawItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RawItemBinding.inflate(layoutInflater, parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.binding.apply {
            tvName.text = employeeModel[position].name
            tvSalary.text = employeeModel[position].salary.toString()
            btnDelete.setOnClickListener(){
                onItemDelete?.invoke(employeeModel[position],position)
            }
            btnEdit.setOnClickListener(){
                onUpdate?.invoke(employeeModel[position],position)
            }
        }
    }
    override fun getItemCount(): Int {
        return employeeModel.size
    }


}
