using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Player_Scene2_Manger : MonoBehaviour
{
    private Text txtPlayerName;
    private UserResponse userResponse;
    // Start is called before the first frame update
    void Start()
    {
        userResponse = UserResponse.getInstance();

        txtPlayerName = GameObject.Find("txtName").GetComponent<Text>();

        txtPlayerName.text = userResponse.name;
    }

    // Update is called once per frame
    void Update()
    {

    }
}
