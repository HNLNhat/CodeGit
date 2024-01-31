var $ = document.querySelector.bind(document)
var $$ = document.querySelectorAll.bind(document)

var form = $('#form')
var mssv = $('#msv')
var fullName = $('#name')
var email = $('#email')
var genders = $$('input[name="gender"]')
var interests = $$('input[name="checkbox"]')
var nationality = $('#nationality')
var note = $('#note')

form.addEventListener('submit', e => {
    e.preventDefault()
    validator()
})

function validator() {
    
    if (mssv.value === '') {
        errorMessage(mssv, 'Không để trống mã')
    } else {
        successMessage(mssv)
    }

    
    if (fullName.value === '') {
        errorMessage(fullName, 'Không để trống họ tên ')
    } else {
        successMessage(fullName)
    }

    
    if (email.value === '') {
        errorMessage(email, 'Không để trống email ')
    } else {
        successMessage(email)
    }

    
    if (!genders[0].checked && !genders[1].checked) {
        $('.gender').innerText = 'Phải chọn giới tính'
        $('#frames').style.background = 'yellow'
    } else {
        $('.gender').innerText = ''
        $('#frames').style.background = 'none'
        $('#frames').style.borderColor = 'green'
    }

   
    var check = 0
    for (var i = 0; i < interests.length; i++) {
        if (interests[i].checked == true) {
            check++
        }
    }
    if (check == 0) {
        $('.hobby').innerText = 'Phải chọn sở thích'
        $('#frames2').style.background = 'yellow'
    } else {
        $('.hobby').innerText = ''
        $('#frames2').style.background = 'none'
        $('#frames2').style.borderColor = 'green'
    }

    
    if (nationality.value == 0) {
        $('.nationality').innerText = 'Phải chọn quốc tịch'
        $('select').style.background = 'yellow'
    } else {
        $('.nationality').innerText = ''
        $('select').style.background = 'none'
        $('select').style.borderColor = 'green'
    }

   
    if (note.value.length > 200) {
        errorMessage(note, 'Ít hơn 200 ký tự')
    } else {
        successMessage(note)
    }
}


function errorMessage(input, message) {
    var formGroup = input.parentElement
    var span = formGroup.querySelector('span')
    formGroup.className = 'form-group error'
    span.innerText = message
}


function successMessage(input) {
    var formGroup = input.parentElement
    formGroup.className = 'form-group success'
} 