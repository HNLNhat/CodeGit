using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Menu_Manger : MonoBehaviour
{
    [SerializeField] private Text txtPlayerName;
    [SerializeField] private Text txtPlayerAge;
    // Start is called before the first frame update
    void Start()
    {
        UserResponse userResponse = UserResponse.getInstance();

        txtPlayerName.text = userResponse.name;
        txtPlayerAge.text = userResponse.age.ToString();
    }

    // Update is called once per frame
    void Update()
    {

    }
}
