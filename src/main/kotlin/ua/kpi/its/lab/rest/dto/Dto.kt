package ua.kpi.its.lab.rest.dto

class EmployeeRequest {
    var fullName: String? = null
        private set
    var category: String? = null
        private set
    var position: String? = null
        private set

    constructor()
    constructor(fullName: String?, category: String?, position: String?) {
        this.fullName = fullName
        this.category = category
        this.position = position
    }
}


class EmployeeResponse {
    var id: Long? = null
        private set
    var fullName: String? = null
        private set
    var category: String? = null
        private set
    var position: String? = null
        private set

    constructor()
    constructor(id: Long?, fullName: String?, category: String?, position: String?) {
        this.id = id
        this.fullName = fullName
        this.category = category
        this.position = position
    }
}


class EnterpriseRequest {
    var name: String? = null
        private set
    var industry: String? = null
        private set
    var legalAddress: String? = null
        private set

    constructor()
    constructor(name: String?, industry: String?, legalAddress: String?) {
        this.name = name
        this.industry = industry
        this.legalAddress = legalAddress
    }
}


class EnterpriseResponse {
    var id: Long? = null
        private set
    var name: String? = null
        private set
    var industry: String? = null
        private set
    var legalAddress: String? = null
        private set

    constructor()
    constructor(id: Long?, name: String?, industry: String?, legalAddress: String?) {
        this.id = id
        this.name = name
        this.industry = industry
        this.legalAddress = legalAddress
    }
}

