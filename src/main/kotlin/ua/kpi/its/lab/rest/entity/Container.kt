package ua.kpi.its.lab.rest.entity

interface Container<T> {
    fun add(element: T)
    fun get(index: Int): T
    fun getAll(): List<T>
    fun update(index: Int, element: T)
    fun remove(index: Int)
}

class EnterpriseContainer : Container<Enterprise> {
    private val enterprise: MutableList<Enterprise> = mutableListOf()
    override fun add(element: Enterprise) {
        enterprise.add(element)
    }

    override fun get(index: Int): Enterprise {
        return enterprise[index]
    }

    override fun getAll(): List<Enterprise> {
        return enterprise
    }

    override fun update(index: Int, element: Enterprise) {
        enterprise[index] = element
    }

    override fun remove(index: Int) {
        enterprise.removeAt(index)
    }
}